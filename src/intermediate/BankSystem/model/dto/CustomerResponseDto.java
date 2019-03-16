package intermediate.BankSystem.model.dto;

import java.util.ArrayList;
import java.util.List;

import intermediate.BankSystem.model.CachedCustomer;

public class CustomerResponseDto {

	private CachedCustomer customer;

	private List<String> errors = new ArrayList<>();

	private List<String> success = new ArrayList<>();

	public CachedCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CachedCustomer customer) {
		this.customer = customer;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getSuccess() {
		return success;
	}

	public void setSuccess(List<String> success) {
		this.success = success;
	}

	public boolean hasErrors() {
		return errors.size() > 0;
	}

}
