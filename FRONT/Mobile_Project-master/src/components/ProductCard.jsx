import {Text , TouchableOpacity , View , ImageBackground } from 'react-native';

const ProductCard = ({onPress,ImageSource,title}) => {
    return ( 
        <TouchableOpacity onPress={()=>{onPress()}}>
            <View className="flex flex-col bg-white rounded m-0.5">
                <ImageBackground source={ImageSource} resizeMode="contain" 
                className="h-40 mx-2"
                />
                <Text className="font-bold px-2 mb-2">Price : 7800 DH</Text>
                <Text className="font-normal px-2 mb-2">{title}</Text>
            </View>
        </TouchableOpacity>
    );
}   

export default ProductCard;