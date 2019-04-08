package fr.pizzeria.exception;



public class PizzaException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	public PizzaException(String message){
		super(message);
	}
	
	public PizzaException(String message, Throwable cause){
		super(message, cause);
	}

}
