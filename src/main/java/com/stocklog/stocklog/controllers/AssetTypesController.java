package com.stocklog.stocklog.controllers;

import com.stocklog.stocklog.data.AssetType;
import com.stocklog.stocklog.data.AssetTypeMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/assetTypes")
public class AssetTypesController {

    private final AssetTypeMapper assetTypeMapper;

    public AssetTypesController(AssetTypeMapper assetTypeMapper) {
        this.assetTypeMapper = assetTypeMapper;
    }

    @GetMapping
    public String getAssetTypes(Model model) {
        log.info("Querying all asset types");
        List<AssetType> assetTypes = assetTypeMapper.selectAll();
        log.debug("Asset types found: {}", assetTypes.size());

        model.addAttribute("assetTypes", assetTypes);

        log.info("Returning asset types");
        return "assetTypes";
    }
}
