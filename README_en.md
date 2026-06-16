<p align="center"><b><a href="README.md">中文</a> | <a href="README_en.md">English</a></b></p>

# ☕ Java Board-Style Teaching Course

> From System.out.println to building a complete library management system

## What Is This?

A course built for **people who want to learn Java but are intimidated by "object-oriented programming"**.

This isn't one of those "here's some code, figure it out yourself" courses -- every lesson comes with **real-life analogies, line-by-line comments, practice exercises, and reference answers**. 18 lessons will take you from `Hello World` to writing a complete library management system on your own.

Every lesson includes a "congratulations" moment to keep you motivated, and every concept is paired with a real-life analogy to help it click. By the time you finish, you'll understand why Java is one of the most widely used programming languages in the world.

## How to Run

```bash
# Navigate to the course directory
cd "d:/VS project/Mimo project/s_java"

# Compile and run any lesson
javac 00_零基础入门.java
java HelloWorld

# Or just use an IDE (recommended)
```

## What Will You Learn?

### Stage 1: Laying the Foundation 🏗️
Learn to "talk" to Java. Variables, operators, conditionals, loops -- the building blocks of all Java code.

| # | What You'll Build | Along the Way You'll Learn |
|---|-------------------|---------------------------|
| 00 | Hello World + Personal Info Card | println, variables, comments |
| 01 | Temperature Converter | Data types, type casting, constants |
| 02 | Simple Calculator | Operators, precedence |
| 03 | Leap Year Checker | if-else, switch |
| 04 | Multiplication Table | for, while, do-while |
| 05 | Student Grade Statistics | Arrays, traversal, finding min/max |
| 06 | Recursive Factorial | Methods, parameters, return values, overloading |

### Stage 2: Object-Oriented Programming 🧱
The soul of Java -- classes, inheritance, polymorphism. This is what sets Java apart from other languages.

| # | What You'll Build | Along the Way You'll Learn |
|---|-------------------|---------------------------|
| 07 | Student Management System (Simple) | Classes, objects, constructors |
| 08 | Zoo Simulator | Inheritance, polymorphism, abstract classes |
| 09 | Safe Division | try-catch, custom exceptions |
| 10 | Text Processor | String, StringBuilder |
| 11 | Student Grade Manager | ArrayList, HashMap, HashSet |
| 12 | Generic Container | Generics, interfaces |

### Stage 3: Leveling Up ⚡
File I/O, Lambda expressions, multithreading -- make your programs persistent and concurrent.

| # | What You'll Build | Along the Way You'll Learn |
|---|-------------------|---------------------------|
| 13 | Config File Parser | File read/write, NIO |
| 14 | Data Filter | Lambda, Stream, method references |
| 15 | Concurrent Downloader | Thread, volatile, wait/notify, deadlocks |

### Stage 4: Capstone Projects 🎯
Bring everything together. From command-line tools to a complete application.

| # | What You'll Build | What It Uses |
|---|-------------------|-------------|
| 16 | Development Practice | Calculator + To-do list |
| 17 | Library Management System | OOP + Files + Collections + Exceptions |

## File Structure

```
s_java/
├── 00_零基础入门.java           ← Start here
├── 01_变量与数据类型.java       ← Temperature converter
├── 02_运算符与表达式.java       ← Simple calculator
├── 03_条件语句.java             ← Leap year checker
├── 04_循环语句.java             ← Multiplication table
├── 05_数组.java                 ← Student grade statistics
├── 06_方法.java                 ← Recursive factorial
├── 07_面向对象编程.java         ← Student management system
├── 08_继承与多态.java           ← Zoo simulator
├── 09_异常处理.java             ← Safe division
├── 10_字符串操作.java           ← Text processor
├── 11_集合框架.java             ← Student grade manager
├── 12_泛型与接口.java           ← Generic container
├── 13_文件操作.java             ← Config file parser
├── 14_Lambda与Stream.java      ← Data filter
├── 15_多线程.java               ← Concurrent downloader
├── 16_开发实战入门.java         ← Calculator + To-do list
├── 17_项目实战.java             ← Library management system
└── README.md                   ← You are here
```

## A Few Tips

1. **Don't skip lessons** -- Later lessons build on earlier ones. Skip and you'll be lost.
2. **Don't just read** -- Compile, run, change parameters, and see what happens.
3. **Do the exercises** -- They're not decoration. Try solving them yourself before checking the answers.
4. **Understand OOP** -- Object-oriented programming is the soul of Java. Draw class diagrams to help.
5. **Read compiler errors** -- The Java compiler gives detailed error messages. Read them carefully and they'll make sense.

## Requirements

- **JDK 8+** -- JDK 17 or later is recommended. Download from [oracle.com](https://oracle.com/java)
- **Editor** -- VS Code with the Java extension, or IntelliJ IDEA

## Course Features

- 🎯 **Real-life analogies** -- Every lesson includes them, turning abstract concepts into everyday examples
- 📝 **Line-by-line comments** -- Every line of code is explained
- 🧮 **Hands-on projects** -- Not isolated snippets, but complete programs you can actually run
- ⚠️ **Common pitfalls** -- Mistakes are flagged so you can avoid them
- 📋 **Practice exercises** -- 3-5 per lesson, with prompts, hints, and reference answers
- 🎉 **Congratulations moments** -- Every lesson ends on a positive note so you never feel lost

## Learning Roadmap

```
Getting Started (00)
    ↓
Basic Syntax (01-06)       ← Variables, operators, conditionals, loops, arrays, methods
    ↓
Object-Oriented (07-08)    ← Classes, inheritance, polymorphism (the soul of Java)
    ↓
Advanced Features (09-15)  ← Exceptions, collections, generics, Lambda, multithreading
    ↓
Capstone Projects (16-17)  ← Calculator, library management system
```

## Core Java Concepts

### Object-Oriented Programming
- **Class** = blueprint, **Object** = the actual thing
- **Inheritance** = genetics, **Polymorphism** = same action, different behavior
- **Interface** = a contract -- sign it and you must fulfill it

### Strong Typing
- Every variable must have a declared type
- Types are checked at compile time, reducing runtime errors

### Cross-Platform
- Write once, run anywhere
- The JVM (Java Virtual Machine) handles execution

---

> "Java is one of the most widely used programming languages in the world. Finish this course, and you'll be able to build Android apps, web backends, and enterprise software."
