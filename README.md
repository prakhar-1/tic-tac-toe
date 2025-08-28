# Tic-Tac-Toe — Low-Level Design (LLD)

A detailed Low-Level Design of a Tic-Tac-Toe game, collaboratively created by SGN team members.

This repository presents a thoughtfully designed architecture, with clear separation of concerns and abstraction of game logic, turn rules, and win detection.

---

## 📌 Table of Contents

- [Overview](#overview)  
- [Architecture & Organization](#architecture--organization)  
- [Getting Started](#getting-started)  
- [Design Highlights](#design-highlights)  
- [Extending / Contributing](#extending--contributing)  
- [License](#license)

---

## 🔎 Overview

This project aims to implement a robust, modular Tic-Tac-Toe engine in Java, emphasizing **clean Low-Level Design (LLD)** practices. Key goals include:

- Clear separation of game initialization, logic, and strategies  
- Extensible turn-taking and win-game mechanisms (via Strategy Pattern)  
- Maintainable and testable architecture, suitable for enhancements like AI opponents or multiplayer support

---

## 🏗 Architecture & Organization

| Component              | Responsibility |
|------------------------|----------------|
| `GameInit`, `GameConfig` | Initializes game configuration (board size, players) |
| `iTurn`, `TurnStrategy1` | Defines how players take turns |
| `iWinner`, `WinStrategy1` | Logic for detecting wins |
| `PlayGame`             | Core game loop — handles player turns, win checks, and UI |
| Strategy Interfaces    | Enables plugging in custom rules for turn-taking or victory conditions |

This design aligns well with SOLID principles, particularly **Single Responsibility**, **Open/Closed**, and **Dependency Inversion**.
Here is the link of design thought process - https://excalidraw.com/#json=llY7-CKMv1uZTbhjtTmQs,NP3qD0UCHa6-tpHqoLIdQQ

---

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/prakhar-1/tic-tac-toe.git
   cd tic-tac-toe
   ```

2. **Build the project:**
   If using Maven:
   ```bash
   mvn clean package
   ```
   Or compile directly:
   ```bash
   javac Path/To/*.java
   ```

3. **Run the game:**
   ```bash
   java PlayGame
   ```

   Follow on-screen prompts to configure and play.

---

## 💡 Design Highlights

- **Strategy Pattern**: Turn-taking and win-detection logic are decoupled via interfaces (`iTurn`, `iWinner`), making the system extensible for different rule variants.  
- **Builder Pattern**: `GameInitBuilder` cleanly handles game setup and validation.  
- **Testability**: Modular design allows unit testing of individual strategies or game scenarios independently.  
- **Separation of Concerns**: Initialization, game engine, and rules are well partitioned, easing future maintenance.  

---

## 🤝 Extending / Contributing

To enhance the project:

- **Add a new turn strategy**: Create a class implementing `iTurn` and inject it via configuration.  
- **Implement alternative win rules**: e.g., implement "4 in a row" or team-based variants via `iWinner` interface.  
- **Improve UI**: Replace console interactions in `PlayGame` with GUI or web interfaces by abstracting the input/output.  
- **Add tests**: Unit test strategies and game scenarios to validate correctness.  

Contributions are welcomed—feel free to submit pull requests, create issues, or share ideas!

---

## 📜 License

This project is **MIT licensed**. See the [LICENSE](LICENSE) file for details.
