


class UsersDAO {

    constructor(conn, table) {
        this.conn = conn;
        this.table = table;
    }
	
	login(username, password) {
		return new Promise( (resolve, reject) => { 
			this.conn.query(`SELECT * FROM ${this.table} WHERE username = ? AND password = ?`,
						   [username, password], (error, results, fields) => {
				if(error){
                    reject(error)
                } else if (results.length == 1) {
					// console.log(results);
                    resolve(results)
                } else {
                    resolve(null)
                };
			});
		});
	}
	
	findByID(id) {
		return new Promise( (resolve, reject) => {
			this.conn.query(`SELECT * FROM ${this.table} WHERE ID = ?`,
						   [id], (error, results, fields) => {
				if(error){
					reject(error);
				} else if (results.length == 1) {
					// console.log(results);
					resolve(results);
				} else {
					resolve(null);
				}
			});
		});
	}
	
}

module.exports = UsersDAO;