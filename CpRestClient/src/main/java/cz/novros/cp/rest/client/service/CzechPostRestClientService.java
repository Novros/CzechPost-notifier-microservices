package cz.novros.cp.rest.client.service;

import java.util.Collection;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import cz.novros.cp.common.service.CzechPostService;
import cz.novros.cp.rest.client.entity.EntityConverter;
import cz.novros.cp.rest.client.rest.CzechPostRestClient;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CzechPostRestClientService implements CzechPostService {

	CzechPostRestClient restClient;

	@Autowired
	public CzechPostRestClientService(@Nonnull final CzechPostRestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public Collection<cz.novros.cp.common.entity.Parcel> readParcels(@Nonnull final Collection<String> trackingNumbers) {
		return trackingNumbers.isEmpty() ? ImmutableList.of() : EntityConverter.convertParcels(restClient.readParcels(trackingNumbers));
	}
}
