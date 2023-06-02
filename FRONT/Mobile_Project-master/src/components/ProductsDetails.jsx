import { Text , View ,ImageBackground , StyleSheet , Dimensions} from "react-native";
import MapView, { Marker }  from 'react-native-maps';
import { Icon } from 'react-native-elements';



const ProductDetails = (props) => {

    const initialRegion = {
        latitude: 31.7917,
        longitude: -7.0926,
        latitudeDelta: 0.0922,
        longitudeDelta: 0.0421,
    };
    

    return ( 
        <>  
            <Text className="text-lg font-semibold mb-5 w-full px-4">
                {props.Title}
            </Text>
            <ImageBackground
            source={{uri:props.image}} 
            className="w-96 h-44 mb-5"
            resizeMode="contain">
            </ImageBackground>
            <View className="flex flex-col gap-y-2 w-full px-4">
                <Text className="text-lg font-bold text-green-500">{props.price} DH</Text>
                <Text className="font-medium">Product Details :</Text>
                <Text className="w-full leading-5 mb-2">
                    {props.About}
                </Text>
                <View className="flex flex-row items-center bg-blue-500 self-start py-1 px-2 rounded">
                    <Icon className="pr-2" name="phone" type="font-awesome" size={20} color="#ffff" />
                    <Text className="text-white text-sm font-semibold">{props.phone}</Text>
                </View>
                <Text className="w-2/6 font-semibold rounded-sm 
                ">Location </Text>
                <View className="flex-1 w-full">
                    <MapView style={styles.map} initialRegion={initialRegion}>
                        <Marker coordinate={{ latitude: 33.6835, longitude: -7.3849 }}/>
                    </MapView>
                </View>
            </View>
        </> 
    );
}

const mapheight =  Dimensions.get('window').height;
const mapModiHeight = mapheight * 0.24;

const styles = StyleSheet.create({
    map: {
        width: '100%',
        height: mapModiHeight
    },
});

export default ProductDetails;