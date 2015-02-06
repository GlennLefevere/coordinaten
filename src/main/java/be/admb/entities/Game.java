/**
 * (c) 2015 ADMB. All rights reserved.
 */
package be.admb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author infglef
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private long id;
	private String city;
	private Team visitors;
	private Team home;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 * the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the visitors
	 */
	public Team getVisitors() {
		return visitors;
	}

	/**
	 * @param visitors
	 * the visitors to set
	 */
	public void setVisitors(Team visitors) {
		this.visitors = visitors;
	}

	/**
	 * @return the home
	 */
	public Team getHome() {
		return home;
	}

	/**
	 * @param home
	 * the home to set
	 */
	public void setHome(Team home) {
		this.home = home;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return visitors.toString() + " " + home.toString() + "\n" + visitors.getScore() + " " + home.getScore();
	}

}
