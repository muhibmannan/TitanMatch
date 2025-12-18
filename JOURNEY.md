# My Engineering Journey: From Junior to Tier 1

## Phase 1: The Logical Core (Current)

- **Goal:** Build a working matching engine.
- **Approach:** Used `ArrayList` for simplicity.
- **Discovery:** I realized `ArrayList` creates a FIFO queue, which causes price priority bugs (cheap buyers blocking rich buyers).
- **Next Step:** Need to implement a `PriorityQueue` (Heap) to solve this.

## Phase 2: Performance Optimization (COMPLETED)

- [x] Replace O(N) linear search with O(log N) PriorityQueue.
- [ ] Implement JUnit tests for stress testing.

**Dev Log (19/12/2025):**
Refactored the core engine from `ArrayList` to `PriorityQueue`.

- **Problem:** The previous FIFO logic allowed low-bid buyers to block high-bid buyers (Head-of-Line Blocking).
- **Solution:** Implemented a Max-Heap for Buy orders and Min-Heap for Sell orders using custom `Comparator`.
- **Result:** The engine now automatically matches the best price first, regardless of arrival time. Complexity improved from O(N) to O(log N).

## Phase 3: Concurrency (Planned)

- [ ] Implement `synchronized` blocks to handle multi-threaded race conditions.
