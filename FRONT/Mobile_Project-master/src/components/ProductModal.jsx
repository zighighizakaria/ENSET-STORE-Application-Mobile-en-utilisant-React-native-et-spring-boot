import { Modal, StyleSheet, Text, Pressable ,View ,SafeAreaView , Dimensions }from 'react-native';
import React, { useState ,forwardRef } from 'react';
import ProductDetails from './ProductsDetails';

const ProductModal = forwardRef((props,ref) => {
    const [modalVisible, setModalVisible] = useState(false);
    const [product,setProduct]=useState({});
    const modalFunction = (product) =>{
        setProduct(product)
        setModalVisible(true)
    }
    React.useImperativeHandle(ref, () => ({
        modalFunction
    }));

    return ( 
        <>
        <Modal
            animationType="slide"
            transparent={true}
            visible={modalVisible}
            onRequestClose={() => {
            setModalVisible(!modalVisible);
            }}>
            <SafeAreaView>
                  <View className="w-full" style={styles.modalView}>
                      <View className="w-full py-5 items-end justify-center">
                          <Pressable 
                          onPress={()=>{setModalVisible(!modalVisible)}}
                          className="mx-5">
                            <Text className="text-base text-blue-500">close</Text>
                          </Pressable>
                      </View>
                      <ProductDetails phone={product.phone} image={product.image} Title={product.title} About={product.about} price={product.price}/>
                  </View>
            </SafeAreaView>
        </Modal>
        </>
    );
});
const windowHeight = Dimensions.get('window').height;

const styles = StyleSheet.create({
    centeredView: {
      flex: 1,
      flexDirection: 'column',
    },
    modalView: {
      backgroundColor: 'white',
      height: windowHeight,
      alignItems: 'center',
      shadowColor: '#000',
      shadowOffset: {
        width: 0,
        height: 2,
      },
      shadowOpacity: 0.25,
      shadowRadius: 4,
      elevation: 5,
    },
    button: {
      borderRadius: 20,
      padding: 10,
      elevation: 2,
    },
});


export default ProductModal;