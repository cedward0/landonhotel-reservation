package com.landonhotel.reservations.service;

import com.landonhotel.reservations.model.Reservation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public interface ReservationService
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	Mono<Reservation> getReservation(String id);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   reservationMono
	 * @return
	 */
	Mono<Reservation> createReservation(Mono<Reservation> reservationMono);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @param   reservationMono
	 * @return
	 */
	Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	Mono<Boolean> deleteReservation(String id);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	Flux<Reservation> listAllReservations();
}
