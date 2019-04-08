package fr.pizzeria.exception;


public class StockageException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	/**
	 * @param arg0
	 * @param arg1
	 */
	public StockageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}




	public StockageException(){
		super();
	}
	
	public StockageException (String message){
		super(message);
	}
	

}
