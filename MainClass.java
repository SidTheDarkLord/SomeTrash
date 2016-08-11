package epam;

import java.util.Scanner;

public class MainClass {

	/*Баги:
	при добавлении в корзину такого же товара кол-во не увеличивается, а заменяется
	(сделать проверку на наличие такого товара, если есть, увеличить кол-во)
	если сделать два заказа в одно время, заказ заменяется
	(добавить ко времени секунды?) и
	(сделать так, чтоб в заказ добавлялись элементы и после перезапуска программы; как, хз)
	*/
	public static void main(String[] args) {

		new Purchase();

		Scanner in = new Scanner(System.in);
		boolean b = true;
		while(b) {
			System.out.println("Вы хотите сделать еще один заказ?");
			String s1 = in.nextLine();
			if(s1.equals("yes") || s1.equals("да")) {
				new Purchase();
				b = false;
			} else if(s1.equals("no") || s1.equals("нет")) {
				b = false;
			} else {
				System.out.println("Введите \"yes\" или \"no\"");
			}
		}

		Order myOrder = new Order();
		myOrder.printAllOrders();
		myOrder.printClosestOrder();


	}

}
