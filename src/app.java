public class app {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addBeverage("Coke", 0.50);
        vm.addBeverage("Water", 0.30);
        vm.addBeverage("Beer", 1.00);
        vm.refillColumn(1, "Coke", 1);
        vm.refillColumn(2, "Beer", 10);
        vm.refillColumn(3, "Coke", 15);
        vm.refillColumn(4, "Water", 20);
        System.out.println(vm.availableCans("Coke"));
        System.out.println(vm.getPrice("Coke"));
        vm.rechargeCard(12, 5.5);
        vm.rechargeCard(21, 10.0);
        vm.rechargeCard(99, 0.75);
        vm.sell("Coke", 12);
        vm.sell("Coke", 99);
        vm.sell("Water", 12);
        System.out.println(vm.availableCans("Coke"));
        System.out.println(vm.getCredit(12));
    }
}