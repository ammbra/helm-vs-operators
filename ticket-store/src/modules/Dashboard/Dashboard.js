import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as api from '../../shared/api.js';
import Cart from '../Cart/cart';
import * as filterActions from '../Filters/action';
import FilterMenu from "../Filters/FilterMenu";
import MenuItemList from '../Menu/menuItemList';
import * as actions from './action.js';

class Dashboard extends Component {
    componentDidMount() {
        const options = [];
        api.getAllLandmarks()
        .then((response) => {
            const items = response.data;
            Object.keys(items).forEach(key => options.push({category: "Landmarks", items: [items[key]]}));
        })
        .catch(error => {
            console.log(error);
        });

        api.getAllEvents()
            .then((response) => {
                const items = response.data;
                Object.keys(items).forEach(key => options.push({category: "Events", items: [items[key]]}));
                this.props.loadItems(options);
                this.props.filterMenu(options);
            })
            .catch(error => {
                console.log(error);
                this.props.loadItems([]);
                this.props.filterMenu([]);
            });
    }

    render() {
        return (
            <Fragment>
                <div className="col col-md-12 col-xs-12 filter-container">
                    <FilterMenu />
                </div>
                <div className="col col-md-9 col-xs-8 menu-container">
                    <MenuItemList />
                </div>
                <div className="col col-md-3 col-xs-4 summary-container">
                    <Cart />
                </div>
            </Fragment>
        );
    }
}

//  Set the actions which will prompt the reducers to check for matching types
function mapDispatchToProps(dispatch) {
    return bindActionCreators({
        loadItems: actions.loadItems,
        filterMenu: filterActions.filterMenu
    }, dispatch);
}

export default connect(null, mapDispatchToProps)(Dashboard);