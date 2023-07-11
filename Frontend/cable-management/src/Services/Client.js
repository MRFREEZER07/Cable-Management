import axios from 'axios';

export const getAllCustomers = async()=>{
    try{
        return await axios.get(`${import.meta.env.VITE_API_BASEURL}/api/v1/customer/all`)
    }catch(e){
        throw e;
    }
}