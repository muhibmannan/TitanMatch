# TitanMatch: Low-Latency Order Matching Engine

A high-performance limit order book (LOB) engine written in Java. Designed to simulate the core matching logic used in High-Frequency Trading (HFT) systems.

## 🚀 Features
- **Price-Time Priority Matching:** Ensures best execution for traders.
- **Thread-Safe Architecture:** (In Progress) Handles concurrent order submissions.
- **Zero-Garbage Object Pooling:** (Planned) Optimized for low latency.

## 🛠 Tech Stack
- **Language:** Java 17+
- **Core:** PriorityQueues, HashMaps
- **Testing:** JUnit 5

## 📈 Evolution
This project tracks my progression from basic collections to advanced systems programming:
1.  **v0.1:** Initial `ArrayList` implementation (Logic Proof).
2.  **v0.2:** `PriorityQueue` optimization for O(log n) matching logic. (Current)
3.  **v1.0:** Concurrent implementation using Locking strategies. (Coming Soon)