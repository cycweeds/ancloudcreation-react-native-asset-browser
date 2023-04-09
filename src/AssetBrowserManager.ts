import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export type AssetBroswerProps = {
  urls: string[],
  index?: number,

  /**
   * nativeID 原生组件id  用于iOS组件放大缩小动画
   */
  nativeID?: string
}


export interface Spec extends TurboModule {
  show(prop: AssetBroswerProps): void
}

export default TurboModuleRegistry.getEnforcing<Spec>('AssetBrowserManager');
