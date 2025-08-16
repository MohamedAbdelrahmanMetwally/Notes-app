# 📝 NotesApp

A simple **Android application** for managing notes (**Add ✏️ - View 👀 - Update 🛠 - Delete 🗑**) using **Room Database** and **RecyclerView**.

---

## 📌 Features
- ➕ **Add** new notes easily.
- 📋 **View** all saved notes in a clean list.
- 🛠 **Edit** notes anytime.
- 🗑 **Delete** unwanted notes.
- 🎨 Simple & elegant design using **Material Design**.
- 💾 Local data storage with **Room Database**.

---

## 🛠 Technologies Used
- **Java** – Programming language.
- **Android Studio** – Development environment.
- **Room Database** – For local data persistence.
- **RecyclerView + CardView** – To display notes.
- **Material Components** – For modern UI.
- **ConstraintLayout** – For responsive layouts.
- **MVVM architecture**
- **Single activty multiple fragments**
---
```
📂 Project Structure
com.example.notesapp
├── core
│ └── database
│ ├── Note.java
│ ├── NoteDao.java
│ └── NoteDatabase.java
├── Main
│ ├── ui
│ │ ├── AddOrUpdateFragemnt.java
│ │ ├── MainActivity.java
│ │ └── ShowFragment.java
│ ├── util
│ │ ├── Adapter.java
│ │ ├── FactoryViewModel.java
│ │ └── Repository.java
│ └── viewmodel
│ └── NotesViewModel.java
├── androidTest
│ └── com.example.notesapp
├── test
│ └── com.example.notesapp
├── java (generated)
└── res
├── drawable
└── layout
├── activity_main.xml
├── card.xml
├── fragment_add_or_update_fragemnt.xml
└── fragment_show.xml
```

---

## 🚀 How to Run
1. Open the project in **Android Studio**.
2. Ensure **JDK** and **Android SDK** are installed.
3. Click **Sync Project with Gradle Files**.
4. Run the app on an emulator or physical Android device.

---

## 💡 Future Improvements
- 🔍 Add search functionality for notes.
- ☁️ Sync with Google Drive or Firebase.
- 🌙 Implement dark mode.

---

## 👨‍💻 Developer
- **Name:** Mohamed Abdelrahman Metwally  
- **Email:** mnafe44@gmail.com  
- **GitHub:** [MohamedAbdelrahmanMetwally](https://github.com/MohamedAbdelrahmanMetwally)
