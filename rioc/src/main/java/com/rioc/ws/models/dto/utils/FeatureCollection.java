package com.rioc.ws.models.dto.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class FeatureCollection {
	List<Feature> features = new ArrayList<>();
	
}
