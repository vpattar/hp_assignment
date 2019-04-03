package com.hp.assignment.service;

import java.util.LinkedList;
 
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;
import com.hp.assignment.entity.AssetEntity;
import com.hp.assignment.entity.OrganizationEntity;
import com.hp.assignment.entity.UserEntity;

@Service
public class AssetsMapperServiceImpl implements AssetsMapperService {

//    @Autowired
//    private Mapper mapper;
	
	/*
	 * 	Multiple options here, like a generic mapper like modelmapper, or dozer mapper.
	 *  Written this to kept it simple and fast.
	 */
	@Override
	public AssetEntity fromAssetToEntity(Asset asset) {
		AssetEntity entity = new AssetEntity();

		entity.setId(asset.getId());
		entity.setName(asset.getName());
		entity.setBrand(asset.getBrand());
		entity.setModel(asset.getModel());
		entity.setSerial_number(asset.getSerial_number());
		entity.setType(asset.getType());
		entity.setAcquisition(asset.getAcquisition());
		entity.setWarranty_expiration(asset.getWarranty_expiration());
		AssetEntity parentAsset = new AssetEntity();
		parentAsset.setId(asset.getAsset_id());
		entity.setParentAsset(parentAsset);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(asset.getUser_id());
		entity.setUser(userEntity);
		OrganizationEntity orgEntity = new OrganizationEntity();
		orgEntity.setId(asset.getOwner_id());
		entity.setOrganization(orgEntity);
		entity.setRetired(asset.getRetired());
		entity.setCost(asset.getCost());
		
		return entity;
	}
	
	@Override
	public Asset fromEntityToAsset(AssetEntity entity) {
		Asset asset = new Asset();
		asset.setId(entity.getId());
		asset.setName(entity.getName());
		asset.setBrand(entity.getBrand());
		asset.setModel(entity.getModel());
		asset.setSerial_number(entity.getSerial_number());
		asset.setType(entity.getType());
		asset.setAcquisition(entity.getAcquisition());
		asset.setWarranty_expiration(entity.getWarranty_expiration());
		asset.setOwner_id(entity.getParentAsset().getId());
		asset.setUser_id(entity.getUser().getId());
		asset.setAsset_id(entity.getOrganization().getId());
		asset.setRetired(entity.getRetired());
		asset.setCost(entity.getCost());

		
		return asset;
	}

	@Override
	public List<Asset> fromEntityToAsset(List<AssetEntity> assetEntities) {
		List<Asset> assetsList = new LinkedList<Asset>();
		assetEntities.forEach(entity->assetsList.add(fromEntityToAsset(entity)));
		return assetsList;
	}
	
	@Override
	public List<AssetFullResponse> fromEntityToAssetFullResponse(List<AssetEntity> assetEntities) {
		List<AssetFullResponse> assetsList = new LinkedList<AssetFullResponse>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		assetEntities.forEach(entity->assetsList.add(mapper.map(entity, AssetFullResponse.class)));
		return assetsList;
	}
	
	 /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    
    @Override
	public Page<AssetFullResponse> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<AssetEntity> source) {
        List<AssetFullResponse> dtos = fromEntityToAssetFullResponse(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}