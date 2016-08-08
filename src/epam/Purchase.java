package epam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Purchase {

	//создаем массив с покупками
	Clothing [] purArray = {new Trunks("XL",'r',"D&G","boxers"), new Trunks("XXL",'b',"Zara","panties"), new Trunks("M",'g',"Victoria's secret","briefs")};

	//переносим в список, доступ через методы Arrays
	List<Clothing> purList =  Arrays.asList(purArray);
	//создаем список, защищенный от изменения данных
	CopyOnWriteArrayList<Clothing> cowList = new CopyOnWriteArrayList<>(purList);

	//Задание 1.3.1
	//новый оператор с перегруженными методами, запрет на удаление элементов
	Iterator<Clothing> myIterator = new Iterator<Clothing>() {
		
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currentIndex < cowList.size();
		}

		@Override
		public Clothing next() {
			/*Clothing cl = purList.get(currentIndex);  //делает итерацию только по нужным размерам
														//немного коряво, не перескакивает элемент, а возвращает null
			if (cl.getSize() == "XL" || cl.getSize() == "XXL") {
				return purList.get(currentIndex++);
			} else {
				currentIndex++;
				return null;
			}*/
			return cowList.get(currentIndex++);
		}

		@Override				//надо бы сделать блоки try/cath
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};

	//выводим покупки на экран
	public void print () {

		Iterator<Clothing> itr = myIterator;

		System.out.println("Ваш заказ:");

		while (itr.hasNext()) {
			Clothing cl = itr.next();
			if (cl != null) {     //выводит ненулевые элементы массива
				System.out.println(cl);
			}
		}

	}

}
