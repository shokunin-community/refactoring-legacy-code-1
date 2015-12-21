'use strict';

describe('game output', function () {
  var realRandom, realConsoleLog, output = '';

  beforeEach(function () {
    realRandom = Math.random;
    realConsoleLog = console.log;
    var rand = require('random-seed').create();
    rand.initState();
    
    Math.random = () => { return rand.floatBetween(0, 1) };
    console.log = (string) => { output += string };
  });

  afterEach(function () {
    Math.random = realRandom;
    console.log = realConsoleLog;
  });
  
  it('should match the golden master', function () {
    var gameRunner = require('../gameRunner.js');

    for (let i = 0; i < 1000; i++) {
      gameRunner.run();
    }

    var fs = require('fs');
    var goldenMaster;
    if (!fs.existsSync('goldenMaster.txt')) {
      fs.writeFileSync('goldenMaster.txt', output);
    }

    var goldenMaster = fs.readFileSync('goldenMaster.txt').toString();
    expect(output).toBe(goldenMaster);
  });
});
