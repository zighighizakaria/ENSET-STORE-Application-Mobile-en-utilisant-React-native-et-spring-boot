import {NavigationContainer ,  DefaultTheme} from '@react-navigation/native';
import HeaderMenu from "../components/HeaderMenu";
import Login from './Login';
import LoginStore from "../stores/LoginStore.jsx"

const MyTheme = {
  ...DefaultTheme,
  colors: {
    ...DefaultTheme.colors,
    background: 'rgb(244 244 245)'
  },
};

const Container = () => {
    const {isLogged,changeLogState}=LoginStore();
    return ( 
        <>
        {
            isLogged?
            <NavigationContainer theme={MyTheme}>
                <HeaderMenu/>
            </NavigationContainer>
            :<Login/>
        }
            
        
        </> 
        );
}
 
export default Container;