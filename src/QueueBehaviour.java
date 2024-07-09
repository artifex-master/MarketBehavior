public interface QueueBehaviour {
    void takeInQueue(Person person);
    void releaseFromQueue();
    Person getNextInQueue();
    boolean isQueueEmpty();
}
