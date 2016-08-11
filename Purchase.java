package epam;

import java.text.SimpleDateFormat;
import java.util.*;


public class Purchase {

	private int choiseID;
	private double totalPrice;
	private HashMap<Integer, Clothing> itemsMap = new HashMap<>();
	private LinkedHashMap<Clothing, Integer> basketMap = new LinkedHashMap<>();

	//конструктор
	//при создании объекта сразу добавляются модели
	public Purchase() {
		addItems();
		choiseItems();
		printBasket();

		if (!basketMap.isEmpty()) {
			ordering();
		}
	}

	//забиваем модели в базу
	private void addItems() {

		Clothing tr1 = new Trunks(1, 10999, "L",'r',"D&G","Boxers");
		Clothing tr2 = new Trunks(2, 23999, "XXL",'b',"Zara","Panties");
		Clothing tr3 = new Trunks(3, 17999, "M",'w',"Victoria's secret","Briefs");
		itemsMap.put(tr1.getId(), tr1);
		itemsMap.put(tr2.getId(), tr2);
		itemsMap.put(tr3.getId(), tr3);

	}

	//добавляем покупки в корзину
	private void choiseItems() {

		printItems();

		Scanner in = new Scanner(System.in);
		boolean b1 = true;
		while(b1) {
			System.out.println("Введите ID понравившегося товара.");
			choiseID = in.nextInt();
			if (itemsMap.containsKey(choiseID)) {
				System.out.println("Вы выбрали:");
				System.out.println(itemsMap.get(choiseID));
				b1 = false;
			} else {
				System.out.println("Введите товар из списка!");
			}
		}

		addToBasket();
		nextChoise();

	}

	//выводим товары на экран
	private void printItems() {
		Set<Map.Entry<Integer, Clothing>> se = itemsMap.entrySet();
		System.out.println("Список товаров:");
		for(Map.Entry<Integer, Clothing> me : se) {
			System.out.print("ID: " + me.getValue().getId() + " ");
			System.out.println(me.getValue());
			System.out.println("Стоимость этих труселей: $" + me.getValue().getPrice()/100.0);
		}
	}

	//добавляем товары в корзину
	private void addToBasket() {

		Scanner in = new Scanner(System.in);
		boolean b3 = true;
		while(b3) {
			System.out.println("Добавить этот товар в корзину?");
			String s1 = in.nextLine();
			if(s1.equals("yes") || s1.equals("да")) {
				System.out.println("Какое количество этих труселей вы хотите приобрести?");
				int i1 = in.nextInt();
				basketMap.put(itemsMap.get(choiseID), i1);
				System.out.println("Товар добавлен в корзину");
				b3 = false;
			} else if(s1.equals("no") || s1.equals("нет")) {
				b3 = false;
			} else {
				System.out.println("Введите \"yes\" или \"no\"");
			}
		}

	}

	//выводим товары на экран
	void printBasket() {
		if (basketMap.isEmpty()) {
			System.out.println("Корзина пуста. А твоя жизнь не имеет смысла.");
		} else {
			Set<Map.Entry<Clothing, Integer>> se = basketMap.entrySet();
			System.out.println("Товары в корзине:");
			for (Map.Entry<Clothing, Integer> me : se) {
				System.out.print(me.getKey() + " - ");
				System.out.println(me.getValue() + "шт.");
				totalPrice += me.getKey().getPrice() * me.getValue() / 100.0;
			}
			System.out.println("Общая сумма заказа: $" + totalPrice);
		}
	}

	//продолжаем покупки(внимание - рекурсия)
	private void nextChoise() {

		Scanner in = new Scanner(System.in);
		boolean b2 = true;
		while(b2) {
			System.out.println("Продолжить покупки?");
			String s2 = in.nextLine();
			if(s2.equals("yes") || s2.equals("да")) {
				choiseItems();
				b2 = false;
			} else if(s2.equals("no") || s2.equals("нет")) {
				b2 = false;
			} else {
				System.out.println("Введите \"yes\" или \"no\"");
			}
		}
	}

	//оформляем заказ
	private void ordering() {

		Scanner in = new Scanner(System.in);
		boolean b4 = true;
		while(b4) {
			System.out.println("Хотите оформить заказ?");
			String s1 = in.nextLine();
			if(s1.equals("yes") || s1.equals("да")) {
				Date d = new Date();
				SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy hh:mm");
				Order.orderMap.put(format1.format(d), basketMap);
				System.out.println("Заказ оформлен.");
				b4 = false;
			} else if(s1.equals("no") || s1.equals("нет")) {
				System.out.println("До свидания!");
				b4 = false;
			} else {
				System.out.println("Введите \"yes\" или \"no\"");
			}
		}

	}
}
