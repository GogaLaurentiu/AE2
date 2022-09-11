const bookingsDAO = require("../dao/bookingsDAO");

class BookingsController {

    constructor(db) {
        this.dao = new bookingsDAO(db, "acc_bookings");
    }
	
	async bookAccommodation(req, res){
		if(req.params.accID !== null || req.params.numP !== null || req.params.date !== null || req.params.user !== null){
			try {
				const book = await this.dao.bookAccommodation(req.params.accID, req.params.date, req.params.user, req.params.numP);
				console.log("SUCCESS");
				res.status(200).json({ message: "Booking Success!"});

			} catch (e) {
				res.status(500).json({error: e});
			}
		} else {
			res.status(400).json({error: "Ensure all fields are filled in before submitting!"})
		}
	}
}


module.exports = BookingsController;