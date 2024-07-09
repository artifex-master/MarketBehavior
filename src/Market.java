import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour{
    private Queue<Person> queue;
    private boolean isOrderAccepted;
    private boolean isOrderProcessed;
    private boolean isOrderCompleted;

    public Market() {
        this.queue = new LinkedList<>();
        this.isOrderAccepted = false;
        this.isOrderProcessed = false;
        this.isOrderCompleted = false;
    }

    @Override
    public void takeInQueue(Person person) {
        queue.add(person);
        System.out.println(person.getName() + " is added to the queue.");
    }

    @Override
    public void releaseFromQueue() {
        if(!queue.isEmpty()) {
            Person person = queue.poll();
            System.out.println(person.getName() + " is released from the queue.");
        } else {
            System.out.println("Queue is empty!");
        }
    }

    @Override
    public Person getNextInQueue() {
        return queue.peek();
    }

    @Override
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void acceptOrder() {
        isOrderAccepted = true;
        System.out.println("Order is accepted.");
    }

    @Override
    public void processOrder() {
        if(isOrderAccepted) {
            isOrderProcessed = true;
            System.out.println("Order is being processed.");
        } else {
            System.out.println("Order is not accepted yet.");
        }
    }

    @Override
    public void completeOrder() {
        if(isOrderProcessed) {
            isOrderCompleted = true;
            System.out.println("The order completed.");
        } else {
            System.out.println("Order is being processed.");
        }
    }

    public void update() {
        if (!isQueueEmpty()) {
            Person nextPerson = getNextInQueue();
            System.out.println("Updating market for " + nextPerson.getName());
            acceptOrder();
            processOrder();
            completeOrder();
            releaseFromQueue();
        } else {
            System.out.println("No one in the queue to update.");
        }
    }
}
