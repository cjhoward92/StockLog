package com.stocklog.stocklog.data;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetTypeMapper {
    List<AssetType> selectAll();
}
