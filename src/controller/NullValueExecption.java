package controller;

import java.sql.SQLException;

public class NullValueExecption extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1574947785992501874L;

	public NullValueExecption() {
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason, String SQLState) {
		super(reason, SQLState);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
		// TODO Auto-generated constructor stub
	}

	public NullValueExecption(String reason, String sqlState, int vendorCode,
			Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
		// TODO Auto-generated constructor stub
	}

}
