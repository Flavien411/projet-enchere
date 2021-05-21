import React, {Component} from 'react';
import {MenuItems} from "./MenuItems";
import './Navbar.css';
import {Button} from "../buttons/Button";
import LogiqueModal from "../modal/LogiqueModal";
import Modal from '../modal/Modal';



class Navbar extends Component {
    state = {clicked : false}
    handleClick = () =>{
        this.setState({clicked: !this.state.clicked})
    }

    render() {

        const {revele, toggle} = LogiqueModal();
        return(
            <nav className="NavbarItems">
                <h1 className="navbar-logo">
                    <i className="fas fa-gavel logo"></i>Enchères
                </h1>
                <div className="menu-icon" onClick={this.handleClick}>
                    <i className={this.state.clicked ? 'fas fa-times' : 'fas fa-bars'}></i>
                </div>
                <ul className={this.state.clicked ? 'nav-menu active' : 'nav-menu'}>
                    {MenuItems.map((item,index)=>{
                        return(
                            <li key={index}>
                                <a className={item.cName} href={item.url}>
                                    {item.title}
                                </a>
                            </li>
                        )
                    })}
                </ul>
                <Button onClick={toggle}>Connexion</Button>
                <Modal revele={revele}
                       cache={toggle}
                />
            </nav>
        )
    }
}

export default Navbar;

