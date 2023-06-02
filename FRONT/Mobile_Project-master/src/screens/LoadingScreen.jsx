import { useEffect } from 'react';
import {Text,SafeAreaView,StatusBar,View , Image} from 'react-native';

const LoadingScreen = ({navigation}) => {
    return ( 
        <>
            <StatusBar/>
            <SafeAreaView>
                <View className="h-full w-full flex items-center justify-center pb-20">
                    <Image
                    style={{ width: 400, height: 400 }}
                    source={require("../Icons/STORE.gif")}/>
                </View>
            </SafeAreaView>
        </>
    );
}


export default LoadingScreen;