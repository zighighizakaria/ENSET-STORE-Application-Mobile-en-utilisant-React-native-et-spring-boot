import { createDrawerNavigator, DrawerContentScrollView, DrawerItemList } from '@react-navigation/drawer';
import { View , Text , Image } from 'react-native';
import { useState } from 'react';
import HomeScreen from '../screens/HomeScreen';
import UserScreen from '../screens/UserScreen';
import ProductModal from './ProductModal';
import AddAnnonce from '../screens/AddAnnonce';
import FiltreBycategorie from './FIltreBycatogorie';

const CustomDrawerContent = (props) => {
    const [username,setUserName]=useState("Ahmed !");
    return (
      <DrawerContentScrollView {...props}>
        <View className="p-5">
        <Text className="text-blue-500 font-bold text-base my-2">Welcome : {username}</Text>
        <Image className="my-2 selection:w-20 h-20 p-10" source={require("../Icons/User.png")} />
        </View>
        <DrawerItemList {...props} />
      </DrawerContentScrollView>
    );
  };


const HeaderMenu = () => {

    const Drawer = createDrawerNavigator();
    return (
        <>
        <Drawer.Navigator drawerContent={CustomDrawerContent} initialRouteName="Home">
            <Drawer.Screen name="Accueil" component={HomeScreen} />
            <Drawer.Screen name="Ajouter une annonce" component={AddAnnonce} />
            <Drawer.Screen name="Èlectronique" component={FiltreBycategorie}
            initialParams={{ categorie: "Èlectronique"}} />
            <Drawer.Screen name="véhicule" component={FiltreBycategorie}
            initialParams={{ categorie: "véhicule"}} />
            <Drawer.Screen name="Vêtements" component={FiltreBycategorie}
            initialParams={{ categorie: "Vêtements"}}
            />
        </Drawer.Navigator>
        </>
    )
};



export default HeaderMenu;