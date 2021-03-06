# Unit Testing In Android Room
This is a basic application that will help a developer to learn more about unit testing in android room.

It utilizes android room to store and get data of people's name in a class room.

# Table Of Contents


*  [Introduction](#AboutTheApp)

*  [Steps to take before writing Unit Cases in Android Room ](#steps_before_writin_units_tests)

*  [Installation](#installation)

*  [Run Tests](#runTests)

*  [Dependencies](#dependencies)

*  [Authors](#todo)

*  [Contributing](#contributing)

*  [License](#license)

## Introduction
Unit tests are small tests that examine small portions of the application such as methods and classes. They are several essential unit tests that should be written such as:
- Unit tests for view-model
- Unit tests for the domain layer
- Unit tests for the repository
- Unit tests for the data layer

This project will mainly focus of the units tests that we write in android room for the dao classes.

## Steps to take before writing Unit Cases in Android Room
- Set up an Entity Class
- Create a database
- Write your Dao methods



## Installations

Clone the project

```bash
  git clone https://github.com/Njumbi/Unit-Tests-For-Android-Room
```

Go to android studio compile and install dependencies

Run the app on your emulator or device

## Run Tests
To run our tests click on the run icon that is next to the class name WordsDaoTests() and then select run WordsDaoTests.

If all the test cases pass you will get a green tick in the run console.


## Dependencies

- Room

- Junit

- HILT

- coroutines

- View binding

- Truth

- Android core testing

- espresso


## Authors

- [@Njumbi](https://github.com/Njumbi) - Github Username

## Contributing

Contributions are always welcome!

See [contributing guidelines](https://github.com/github/docs/blob/main/CONTRIBUTING.md) for ways to get started.

Please adhere to this project's `code of conduct`.


## License

[MIT](https://choosealicense.com/licenses/mit/)

