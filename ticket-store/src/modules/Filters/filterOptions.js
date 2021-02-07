import React from 'react';

const FilterOptions = (props) => {
  return (
    <div className="row">
      <div className="col col-xs-3 col-md-3">
        <label htmlFor="namefilter" className="pull-left">Name:</label>
        <input name="namefilter" type="text" autoFocus placeholder="Search" className="inputBox" value={props.filterNameText ? props.filterNameText : ''} onChange={e => props.handleFilteration(e, 'name')} />
      </div>
      <div className="col col-xs-3 col-md-3">
        <label htmlFor="categoryfilter" className="pull-left">Category:</label>
        <select name="categoryfilter" className="inputBox" value={props.filterCategoryText ? props.filterCategoryText : ''} onChange={e => props.handleFilteration(e, 'category')}>
          <option value="">{'All'}</option>
          <option value="Events">{'Events'}</option>
          <option value="Landmarks">{'Landmarks'}</option>
        </select>
      </div>
      <div className="col col-xs-3 col-md-3">
        <label htmlFor="ratingfilter" className="pull-left">Rating:</label>
        <select name="ratingfilter" className="inputBox" value={props.filterRatingText ? props.filterRatingText : ''} onChange={e => props.handleFilteration(e, 'rating')}>
          <option value="">{'All'}</option>
          <option value="1">{'★'}</option>
          <option value="2">{'★★'}</option>
          <option value="3">{'★★★'}</option>
          <option value="4">{'★★★★'}</option>
          <option value="5">{'★★★★★'}</option>
        </select>
      </div>
      <div className="col col-xs-3 col-md-3">
        <label htmlFor="pricefilter" className="pull-left">Price:</label>
        <select name="pricefilter" className="inputBox" value={props.filterPriceText ? props.filterPriceText : ''} onChange={e => props.handleFilteration(e, 'price')}>
          <option value="">{'All'}</option>
          <option value="0,30">{'0 - 30'}</option>
          <option value="30,50">{'30 - 50'}</option>
          <option value="50,75">{'50 - 75'}</option>
          <option value="75,100">{'75 - 100'}</option>
          <option value="100,">{'100+'}</option>
        </select>
      </div>
    </div>
  );
};

export default FilterOptions;
