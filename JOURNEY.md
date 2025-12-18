\# My Engineering Journey: From Junior to Tier 1



\## Phase 1: The Logical Core (Current)

\- \*\*Goal:\*\* Build a working matching engine.

\- \*\*Approach:\*\* Used `ArrayList` for simplicity.

\- \*\*Discovery:\*\* I realized `ArrayList` creates a FIFO queue, which causes price priority bugs (cheap buyers blocking rich buyers). 

\- \*\*Next Step:\*\* Need to implement a `PriorityQueue` (Heap) to solve this.



\## Phase 2: Performance Optimization (Planned)

\- \[ ] Replace O(N) linear search with O(log N) data structures.

\- \[ ] Implement JUnit tests for stress testing.



\## Phase 3: Concurrency (Planned)

\- \[ ] Implement `synchronized` blocks to handle multi-threaded race conditions.

