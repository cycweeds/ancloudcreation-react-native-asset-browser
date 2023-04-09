//
//  AssetBrowserManager.swift
//  ac-react-native-asset-broswer
//
//  Created by cyc on 2023/4/8.
//

import Foundation

import MTPhotoBroswer

@objc(AssetBrowserManager)
class AssetBrowserManager: NSObject {
    
    @objc(show:)
    func show(_ props: NSDictionary) {
        
        let urls = props["urls"]
        let index = (props["index"] as? NSNumber)?.intValue ?? 0
         guard let urlStrings = urls as? [String] else {
            return
        }
        let imageURLs = urlStrings.map {
            if FileManager.default.fileExists(atPath: $0) {
                return URL(fileURLWithPath: $0)
            } else {
                return URL(string: $0)!
            }
        }
        
        guard let vc = RCTPresentedViewController(), let supview = vc.view else {
            return
        }
        let photoBrowserVC = MTAssetBroswerViewController(imageURLs: imageURLs, index: index)
        if let nativeID = props["nativeID"] as? String {
            photoBrowserVC.presentingImageView = findReactNativeImageView(supview: supview, nativeID: nativeID)
        }
        
        vc.present(photoBrowserVC, animated: false)
    }
    
    
    func findReactNativeImageView(supview: UIView, nativeID: String) -> UIImageView? {

        
        if let imageSuperView = supview as? RCTImageView {
            if imageSuperView.nativeID == nativeID, let imageView = imageSuperView.subviews.first as? RCTUIImageViewAnimated {
                return imageView
            }
        } else {
            for subview in supview.subviews {
                let subImageView = findReactNativeImageView(supview: subview, nativeID: nativeID)
                if subImageView != nil {
                    return subImageView
                }
            }
        }
        return nil
    }
    
    
}
