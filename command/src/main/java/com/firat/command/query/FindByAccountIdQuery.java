package com.firat.command.query;

public class FindByAccountIdQuery {

	private String accountId;

	public FindByAccountIdQuery(String accountId) {
		super();
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
	}
}
