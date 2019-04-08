package fr.pizzeria.exception;



public class UpdatePizzaException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	/**
	 * 
	 */
	public UpdatePizzaException() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param arg0
	 * @param arg1
	 */
	public UpdatePizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}



	public UpdatePizzaException(String message){
		super(message);
	}

}
