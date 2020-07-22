package com.landonhotel.reservations.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@Document
public class Reservation
{
	//~ Instance fields --------------------------
	/**  */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkIn;

	/**  */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkOut;

	/**  */
	@Id
	private String id;

	/**  */
	private Integer price;

	/**  */
	private Long roomNumber;
	//~ Constructors -----------------------------
	/** Creates a new Reservation object. */
	public Reservation( ) { }

	/**
	 * Creates a new Reservation object.
	 *
	 * @param  roomNumber
	 * @param  checkIn
	 * @param  checkOut
	 * @param  price
	 */
	public Reservation(Long roomNumber, LocalDate checkIn, LocalDate checkOut, Integer price)
	{
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public LocalDate getCheckIn()
	{
		return checkIn;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param  checkIn
	 */
	public void setCheckIn(LocalDate checkIn)
	{
		this.checkIn = checkIn;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public LocalDate getCheckOut()
	{
		return checkOut;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param  checkOut
	 */
	public void setCheckOut(LocalDate checkOut)
	{
		this.checkOut = checkOut;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Integer getPrice()
	{
		return price;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param  price
	 */
	public void setPrice(Integer price)
	{
		this.price = price;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Long getRoomNumber()
	{
		return roomNumber;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param  roomNumber
	 */
	public void setRoomNumber(Long roomNumber)
	{
		this.roomNumber = roomNumber;
	}
}
