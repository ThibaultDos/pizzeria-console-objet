package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.exception.StockageException;

public abstract class  MenuService {
	abstract void executeUC(Scanner scanner) throws StockageException;

}
