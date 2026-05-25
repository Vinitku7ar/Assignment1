🚚 Logistics App - Order Management Module
📌 Overview
This repository contains the UI implementation of the "My Orders" module for a logistics and goods transportation application. Developed as an internship assignment, this module provides users with a seamless, intuitive interface to track their trip history, manage invoices, and quickly rebook previous routes.

The project leverages modern Android development practices, specifically utilizing Data Binding to tightly couple the UI layouts with the underlying data models, ensuring a robust, maintainable, and boilerplate-free codebase.

✨ Key Features
Categorized Order Tracking: Easy-to-navigate tabs (All Orders, Completed, Cancelled, Booked Again) allow users to filter their trip history seamlessly.

Detailed Order Cards (RecyclerView): Each order is rendered dynamically using optimized RecyclerView adapters and Data Binding, displaying:

Vehicle type (e.g., Four Wheeler) and visual icons.

Transparent pricing and exact timestamps.

Clear Order IDs for easy reference.

Color-coded pickup (🟢) and drop-off (🔴) locations.

Quick Actions: One-tap functionality to Download Invoice or Book Again, efficiently bound to click listeners in the layout.

Advanced Search & Filter: Integrated search bar to locate specific trips by Order ID or Location.

Bilingual Accessibility: Features localized informational banners (e.g., Hindi instructions) to cater to a diverse user base.

Intuitive Navigation: A standard bottom navigation bar (Home, Orders, Payments, Account) paired with a Floating Action Button (FAB).

🛠 Tech Stack & Architecture
UI Implementation: XML Layouts

Core Tooling: Android Data Binding Library

List Management: RecyclerView with custom ViewHolders

Design System: Material Design Components (MDC) for Android, utilizing CardViews, BottomNavigationView, and custom typography.

Architecture Pattern: MVVM (Model-View-ViewModel) ready. The layouts are designed to easily observe live data and state changes directly from a ViewModel.

🎨 Design & Implementation Decisions
Declarative UI Binding: By using Data Binding (<layout>, <data>, and @{} expressions), the project minimizes findViewById calls, preventing null pointer exceptions and memory leaks while keeping the Activity/Fragment classes clean.

Color Palette: The primary yellow theme (#FFCC00 variant) provides an energetic, high-visibility aesthetic standard in the logistics industry.

Component Reusability: The order cards are modularized into separate XML layout files (item_order.xml) using <include> tags and bound to individual data objects for maximum reusability.

🚀 Getting Started
Prerequisites
Android Studio (Latest version recommended)

Gradle build tools configured for Data Binding:

Groovy
android {
    ...
    buildFeatures {
        dataBinding true
    }
}
Installation
Clone the repository:

Bash
git clone https://github.com/yourusername/logistics-order-module.git
Open the project in Android Studio.

Sync the Gradle files to download the required dependencies.

Build and run the application on an emulator or physical device.

🤝 Acknowledgements
Developed as a practical assignment to demonstrate proficiency in XML UI design, Data Binding, and modern Android layout structures.
