Installation Instructions
===============

Open your docker terminal by running the following command in a terminal:
`boot2docker up`

cd into this repository

Run the following command which will pull down the required docker containers and run the program:
`docker run -it -v "$PWD":/usr/src/app shokunincommunity/trivia_ruby`

Run the following command to start guard listening for any code changes:
`docker run -it -v "$PWD":/usr/src/app shokunincommunity/trivia_ruby guard -p`

Now you're ready to code :)

