/**
* @author Team 7
* This class imports images as two assets that (good and bad detectives) and allows for us to use them 
*/
package model;

public enum Detective {

	GOOD("view/resources/detectivechooser/good.png"),
	BAD("view/resources/detectivechooser/bad.png");
	
	private String urlDetective;
	
	/**
	* method creates Detective instance with  urlDetective
	* @param String
	 *@return Detective 
	*/
	private Detective(String urlDetective) {
		this.urlDetective = urlDetective;
		}
	
	/**
	* getter for urlDetective 
	* @param String
	 *@return Detective
	*/
	public String getUrl() {
		return this.urlDetective;
	}

}
