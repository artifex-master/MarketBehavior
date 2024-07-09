//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        // Добавим пару человек в очередь
        market.takeInQueue(new Person("Alice"));
        market.takeInQueue(new Person("Bob"));

        // Обновление состояния магазина
        market.update(); // Обработка первого человека в очереди
        market.update(); // Обработка второго человека в очереди
        market.update(); // Нет людей в очереди для обработки
    }
}