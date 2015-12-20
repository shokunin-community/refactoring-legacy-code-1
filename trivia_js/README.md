Installation Instructions
===============

Open your docker terminal by running the following command in a terminal:
`boot2docker up` or by running the `docker Quickstart Terminal`

cd into this repository

Run the following command which will pull down the required docker containers and run the program:
`docker run -it -v "$PWD":/usr/src/app softwareshokunin/trivia_js`

Run the following command to start guard listening for any code changes:
`docker run -it -v "$PWD":/usr/src/app softwareshokunin/trivia_js jasmine`

Now you're ready to code :)

