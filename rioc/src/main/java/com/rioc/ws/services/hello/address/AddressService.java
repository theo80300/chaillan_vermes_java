package com.rioc.ws.services.hello.address;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.mappers.IAddressMapper;
import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dto.AddressDto;
import com.rioc.ws.models.dto.utils.FeatureCollection;
import com.rioc.ws.repositories.IAddressRepository;

@Service
public class AddressService implements IAddressService{

	private IAddressRepository repository;
	private IAddressMapper mapper;
	
	
	public AddressService (IAddressRepository repository,IAddressMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;

	}
	public Address postAddress(AddressDto address) {
		if (!repository.findByCityAndCountry(address.getCity(), address.getCity()).isEmpty()) {
			throw new  ApiException("Already existe", HttpStatus.CONFLICT);
		}
		
		return repository.save(mapper.addressDtoToAddress(address));
	}
	
	public Boolean getApiAdd(AddressDto address) {
		int street_number = address.getNumber();
		String street = address.getStreet();
		boolean block;
		int postal = address.getPostal();
		String url = "https://api-adresse.data.gouv.fr/search/?q="+Integer.toString(street_number)+"+"+street+"+"+Integer.toString(postal);
		System.out.println(url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			
			FeatureCollection response = restTemplate.getForObject(url, FeatureCollection.class);
			Double score = response.getFeatures().get(0).getProperties().getScore();
			System.out.println(score);
			if(score>0.70) {
				block = true;
			}
			else {
				block = false;
			}
		}
		catch(Exception e){
			System.out.println(url);
			throw new ApiException(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return block;
	}
	
	

	/*public AddressDto getAddressById(int id) {
		Optional <Address> optionAddress = repository.findById(id);
		if(optionAddress.isEmpty()) {
			return null;
		}
		return mapper.addressToAddressDto(optionAddress.get()); //utiliser mapper
	}
	
	public AccountDto deleteAccountById(int id) {
		repository.deleteById(id);
		return null;
	}
	
	public List<AccountDto> getAllAccount() {
		List<Account> Account = repository.findAll();
		if(Account.isEmpty()) {
			return null;
		}
		return Account.stream().map(account->mapper.accountToAccountDto(account)).collect(Collectors.toList()); //utiliser mapper
	}*/

}
