import { NativeModules, Platform } from 'react-native';
import type { AssetBroswerProps } from './AssetBrowserManager';

const LINKING_ERROR =
  `The package '@ancloudcreation/react-native-asset-browser' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null;

const AssetBrowserManager = isTurboModuleEnabled
  ? require('./AssetBrowserManager').default
  : NativeModules.AssetBrowserManager;

const ReactNativeAssetBrowserManager = AssetBrowserManager
  ? AssetBrowserManager
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function browseAssets(props: AssetBroswerProps) {
  return ReactNativeAssetBrowserManager.show(props)
}
