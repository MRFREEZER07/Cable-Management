import {
    createContext,
    useContext,
    useEffect,
    useState
} from 'react';

const AuthContext=createContext({});

const AuthProvider =({children}) =>{
    const [user,setUser]= useState(null)
}

export const userAuth =() =>useContext(AuthContext);