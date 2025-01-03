# Dagger2 Dependency Injection Example

This project demonstrates a basic implementation of the Model-View-ViewModel (MVVM) architectural pattern using dagger2.

**Key Features:**

* **Clean Architecture:** Adheres to the MVVM pattern for better separation of concerns.
* **Jetpack Compose:** Utilizes modern declarative UI with Jetpack Compose.
* **Dagger2:** Implements dependency injection with Hilt for easier maintainability.
* **Coroutines:** Leverages Kotlin Coroutines for asynchronous operations.
* **LiveData:** Utilizes LiveData for observing data changes in the UI.
* **Retrofit:** Integrates with Retrofit for network requests.
* **Kotlin DSL:** Configures the build process using Kotlin DSL for better readability and maintainability.

**Project Structure:**

* **ui:** Contains all the composable functions for UI elements.
* **viewmodel:** Holds the ViewModel classes responsible for managing UI state and data.
* **repository:** Houses the data access layer, interacting with the network or local data sources.
* **model:** Defines data models for the application.
* **retrofit:** Contains interfaces for interacting with the API.
* **di:** Contains modules for dependency injection using Dagger2.

**Getting Started:**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/rj80599/dagger2.git