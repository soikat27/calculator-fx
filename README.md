# CalculatorFX 

A simple Java program that implements a basic calculator with a graphical user interface using JavaFX.

This program lets you perform arithmetic operations including addition, subtraction, multiplication, division, exponentiation, and parentheses handling. It features a clean GUI inspired by modern calculator layouts, with styled buttons and a responsive interface.

This JavaFX implementation of a calculator was created as a learning and portfolio project. Users can run the calculator, while developers can explore the code to understand GUI design, event handling, and stack-based arithmetic evaluation.

## Getting Started

Follow these steps below to get the project running on your computer:

### **Prerequisites**

You’ll need:

* Java JDK (11 or above recommended), which includes both:
    - **Compiler (`javac`)** – to compile Java source files
    - **Runtime (`java`)** – to run compiled programs

* JavaFX SDK 11+ – required to run JavaFX applications

* A terminal or command prompt (macOS/Linux or Command Prompt/PowerShell on Windows)

#### Check that Java JDK is installed:

```
java -version   # checks the Java runtime
```
and
```
javac -version  # checks the Java compiler
```

#### JavaFX Download Guide:

1. Visit the official JavaFX website: [https://gluonhq.com/products/javafx](https://gluonhq.com/products/javafx)

2. Select options for your system:  
   - **JavaFX version:** latest stable release  
   - **Operating system:** Windows / macOS / Linux  
   - **Architecture:** your system’s architecture
   - **Type:** SDK (you need the SDK to compile/run JavaFX programs)
3. Download the SDK and extract it to a folder you can remember.

### **Installing**

#### 1. Clone this repository and Navigate to the project directory:

```
git clone https://github.com/your-username/calculator-fx.git
```

```
cd calculator-fx
```

#### 2. Compile the program:

* Create a folder for compiled bytecode:

```
mkdir bin
```

* Compile the source code into .class files:

```
javac --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -d bin src/*.java src/operators/*.java
```

** Replace `/path/to/javafx/lib` with the path to your JavaFX SDK lib folder.

## Running the program

Run the compiled program from the bin directory:

```
java --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp bin Calculator
```

** Replace `/path/to/javafx/lib` with the path to your JavaFX SDK lib folder.

#### Features:

* Supports basic arithmetic: **`+`**, **`-`**, **`*`**, **`/`**
* Supports exponentiation: **`^`**
* Supports **parentheses** for controlling operation precedence

<img src="./doc/screenshots/calculator.png" alt="CalculatorFX Screenshot" width="200"/>

#### Usage

* Click numeric buttons or operators to build your expression
* Press **`=`** to evaluate
* Press **`C`** to clear the screen.
* The calculator screen is read-only; input via buttons only

#### `Upcoming Features:`

* **Delete / Backspace Feature:** Ability to remove the last input from the screen.
* **Negative Number Input:** Support for entering negative numbers directly.
* **Expanded Input Options:** Allow more flexible or complex inputs in future updates.

## Deployment

There’s no special deployment needed. Compile the program with Java and run it locally from the terminal with the JavaFX module path specified.

## Built With

* Java 11+ – core programming language
* JavaFX 11+ – GUI framework
* Stack-based arithmetic evaluation – for parsing and computing expressions
* `JavaDoc` comments included in source code (see doc/index.html)

## Contributing

Contributions are welcome! Open an issue or submit a pull request if you want to add features or improve the project.

## Author

* Soikat Saha – initial work


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Acknowledgments

* Inspired by the **Shunting Yard Algorithm** developed by **Edsger W. Dijkstra**
* Special thanks to **Professor Ilinkin** for guidance and support throughout this project
* Appreciation to the open-source JavaFX community for providing excellent resources 