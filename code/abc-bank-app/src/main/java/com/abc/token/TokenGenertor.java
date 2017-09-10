package com.abc.token;

import java.util.Scanner;

import com.abc.exception.ApplicationException;
import com.abc.model.Customer;
import com.abc.model.CustomerType;
import com.abc.model.Token;
import com.abc.service.Consumer;
import com.abc.service.CustomerService;
import com.abc.service.TokenService;

/**
 * 
 * @author ankul1874
 * @Purpose This class is a thread class responsible for generating token and
 *          availing token to consumer or token processor.
 */
public class TokenGenertor implements Runnable {

	private CustomerService customerService;

	private TokenService tokenService;

	private Consumer consumer;

	public TokenGenertor(final CustomerService customerService, final TokenService tokenService, Consumer consumer) {
		this.customerService = customerService;
		this.tokenService = tokenService;
		this.consumer = consumer;
	}

	@Override
	public void run() {
		generateToke();
	}

	/*
	 * This method is for generating a token. It handles all input events by
	 * user. It asks if user has customer id or not if not it'll ask customer's
	 * information and will register customer else it'll ask customer id. After
	 * customer id it'll ask which service customer wants Based of service it'll
	 * generate token by assigning available counter for service customer is
	 * looking for.
	 */
	private void generateToke() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Type q to exit !!!! ");
			System.out.println("Do you have customer Id(Y/N)  : ");
			String input = scanner.nextLine();
			String customerId = "";
			String serviceId = "";
			Customer customer;
			if ("y".equalsIgnoreCase(input)) {
				System.out.print("Enter customer id : ");
				customerId = scanner.nextLine();
				customer = customerService.getCustomerById(customerId);
			} else if ("n".equalsIgnoreCase(input)) {
				customer = new Customer();
				System.out.println("Enter your name ");
				String name = scanner.nextLine();
				customer.setName(name);
				System.out.println("Enter your phone ");
				String phone = scanner.nextLine();
				customer.setPhone(phone);
				System.out.println("Enter your address ");
				String address = scanner.nextLine();
				customer.setAddress(address);
				System.out.println("Enter your service type (R for regular, P for Premium) ");
				String serviceType = scanner.nextLine();
				CustomerType customerType = CustomerType.REGUALR;
				if ("R".equalsIgnoreCase(serviceType)) {
					customerType = CustomerType.REGUALR;
				} else if ("P".equalsIgnoreCase(serviceType)) {
					customerType = CustomerType.PREMIUM;
				} else {
					System.out.println("invalid input regular customer will be accepted");
				}
				customer.setCustomerType(customerType.name());
				try {
					customerId = customerService.registerCustomer(customer);
				} catch (ApplicationException e) {
					e.printStackTrace();
				}

			} else if ("q".equalsIgnoreCase(input)) {
				System.out.println("Exit !!");
				break;
			} else {
				System.out.println("Please enter valid option");
				continue;
			}
			serviceId = getServiceId(scanner);
			Token token = tokenService.getToken(customerId, serviceId);

			consumer.consume(token);
		}
		consumer.finishConsumption();
		scanner.close();
	}

	/*
	 * Method to ask service customer wants.
	 */
	private String getServiceId(Scanner scanner) {
		String serviceId;
		System.out.println("Choose options from 1 to 10 below");
		System.out.println("1 : enquiry");
		System.out.println("2 : cash deposit");
		System.out.println("3 : balance enquiry");
		System.out.println("4 : open account");
		System.out.println("5 : cash withrawl");
		System.out.println("6 : check deposit");
		System.out.println("7 : submit documents");
		System.out.println("8 : verify documents");
		String option = scanner.nextLine();
		serviceId = getServiceIdFromOption(option);
		return serviceId;
	}

	/*
	 * Method to map customer required option to actual service available in
	 * system.
	 */
	private String getServiceIdFromOption(String option) {
		String serviceId = "";
		switch (option) {
		case "1":
			serviceId = "abc02";
			break;
		case "2":
			serviceId = "abc07";
			break;

		case "3":
			serviceId = "abc03";
			break;

		case "4":
			serviceId = "abc04";
			break;

		case "5":
			serviceId = "abc08";
			break;

		case "6":
			serviceId = "abc01";
			break;

		case "7":
			serviceId = "abc05";
			break;
		case "8":
			serviceId = "abc06";
			break;
		default:
			break;
		}
		return serviceId;
	}

}
